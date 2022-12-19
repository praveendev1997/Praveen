package practice;

import org.testng.annotations.Test;

public class Example {

		@Test  (priority =4 )
		public void a()
		{
			System.out.println("a");
		}
		@Test  (priority = 5)
		public void b()
		{
			System.out.println("b");
		}
		@Test  (priority =6 )
		public void c()
		{
			System.out.println("c");
		}
		@Test  (priority =1 )
		public void d() {
			System.out.println("d");

		}
		@Test  (priority =2 )
		public void h()
		{
			System.out.println("h");
		}
		@Test  (priority =3 )
		public void r()
		{
			System.out.println("r");
		}

}
