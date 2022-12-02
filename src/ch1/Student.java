package ch1;

public class Student {
    private final String name;
    private final String first;

    public Student() {
        this.name = Builder.name;
        this.first = Builder.first;
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
            Builder.name = name;
            return this;
        }
        public Builder setFirst(String first) {
            Builder.first = first;
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
        Thread t1 = new Thread(() -> student = Student.Builder.newInstance().setFirst(" opr").setName("hello").build());
        Thread t = new Thread(() -> student = Student.Builder.newInstance().setFirst("hello").setName("word").build());
        t.run();
        t1.run();
    }

    public Student getStudent() {
        return student;
    }
}

class run {
    public static void main(String[] args) {
        check c = new check();
        System.out.println(c.getStudent());
        System.out.println(c.getStudent());
    }
}
