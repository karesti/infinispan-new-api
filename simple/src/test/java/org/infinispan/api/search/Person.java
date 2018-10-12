package org.infinispan.api.search;

public class Person {
   String name;

   String surname;

   public Person(String name, String surname) {
      this.name = name;
      this.surname = surname;
   }

   @Override
   public String toString() {
      return "Person [name=" + name + ", surname=" + surname + "]";
   }
}
