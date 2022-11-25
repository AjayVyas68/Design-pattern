package ch1;

public class Student {
    private String name;
    private String first;

    public Student() {
        this.name = Builder.name;
        this.first = Builder.first;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirst(String first) {
        this.first = first;
    }


    public static class Builder {
        static String name;
        static String first;

        public Builder() {

        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFirst(String first) {
            this.first = first;
            return this;
        }

        public Student build() {
            return new Student();
        }
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + this.name + '\'' + ", first='" + this.first + '\'' + '}';
    }
}

class check {

    private volatile Student student;

    public check() {
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                student = Student.Builder.newInstance().setFirst("hello").setName("word").build();
            }

        });
        t.run();
    }

    public Student getStudent() {
        return student;
    }
}

class run {
    public static void main(String[] args) {
        check c = new check();
        System.out.println(c.getStudent());
    }
}
