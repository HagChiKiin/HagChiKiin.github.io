//import com.github.javafaker.Faker;
//
//public class Main {
//    public static void main(String[] args) {
//        // Cách 1 : sử dụng constructor
//        Person person = new Person(1,"Kiên","a@gmail.com");
//        System.out.println(person);
//        // Cách 2 : sử dụng builder
//        Person person1 = Person.builder()
//                .email("a@gmail.com")
//                .name("Kiên")
//                .build();
//        System.out.println(person1);
//
//        // tạo nhiều dối tượng person
//        Faker faker = new Faker();
//        Person [] people = new Person[20];
//        for (int i = 0; i < people.length ; i++) {
//            people[i] = new Person(i+1,faker.name().fullName(),faker.internet().emailAddress());
//        }
//        for (Person p : people
//             ) {
//            System.out.println(p);
//        }
//        System.out.println(faker.leagueOfLegends().champion());
//    }
//}
