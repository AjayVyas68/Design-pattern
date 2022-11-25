package ch1.pizza;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class PizzaIdea {

    public enum Topping {
        TOMATO, CHILLY, SPICY, ONION
    }

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        final EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract PizzaIdea build();

        protected abstract T self();
    }


    PizzaIdea(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

}

class MargeritaPizza extends PizzaIdea {
    enum Size {
        small, medium, large
    }

    private final Size size;

    MargeritaPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static class Builder extends PizzaIdea.Builder<Builder> {
        private final Size size;

        /**
         * @return build method implement  all Pizza create
         */
        @Override
        PizzaIdea build() {
            return new MargeritaPizza(this);
        }

        public Builder(Size size) {
            this.size = size;
        }

        /**
         * @return builder get margerita pizza
         *
         */
        @Override
        protected Builder self() {
            return this;
        }
    }

    public static void main(String[] args) {
        MargeritaPizza m = (MargeritaPizza) new Builder(Size.small)
                .addTopping(Topping.CHILLY)
                .addTopping(Topping.SPICY)
                .addTopping(Topping.TOMATO)
                .addTopping(Topping.ONION).build();
        System.out.println(m.toppings + " " +m.size);

    }
}





