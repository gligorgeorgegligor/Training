public class GeoMain {

	public static void display(Shape[] afis) {

		for (int i = 0; i < afis.length; i++) {
			System.out.println(afis[i]);
		}
	}

	public static void main(String[] args) {

		Shape[] store = new Shape[12];

		store[0] = new Circle(5, MyColor.pink, 32, 2);
		store[1] = new Circle(4, MyColor.blue, 18, 89);
		store[2] = new Circle(3, MyColor.purple, 10, 11);
		store[3] = new Square(10, MyColor.grey, 34, 3);
		store[4] = new Square(11, MyColor.blue, 98, 9);
		store[5] = new Triangle(21, MyColor.blue, 67, 92);
		store[6] = new Triangle(23, MyColor.grey, 45, 11);
		store[7] = new SuperCircle(5, MyColor.pink, 32, 882);
		store[8] = new SuperCircle(44, MyColor.blue, 4, 809);
		store[9] = new SuperCircle(5, MyColor.purple, 10, 811);
		store[10] = new OddTriangle(3, MyColor.blue, 7, 2);
		store[11] = new OddTriangle(2, MyColor.grey, 5, 1);
		display(store);
		
		System.out.println(store[2].merge(store[9]));
			
		
	
	}
}
/*
 * public static void Afisare(Shape cerc[]){
 * 
 * for(int i =0; i < 3; i++){ System.out.println(cerc[i].toString()); } } public
 * static void AfisarePatrat(Square patrat[]){
 * 
 * for(int i =0; i < 3; i++){ System.out.println(patrat[i].toString()); } }
 * 
 * public static void AfisareSuperCerc(SuperCircle Scerc[]){
 * 
 * for(int i =0; i < 3; i++){ System.out.println(Scerc[i].toString()); } }
 * 
 * public static void main(String[] args){
 * 
 * Circle[] sirCerc = new Circle[3];
 * 
 * Square[] sirPatrat = new Square[3];
 * 
 * SuperCircle[] sirSuperCerc = new SuperCircle[3];
 * 
 * sirCerc[0] = new Circle (5, MyColor.pink , 32, 2); sirCerc[1] = new Circle
 * (4, MyColor.blue , 18, 89); sirCerc[2] = new Circle (3, MyColor.purple , 10,
 * 11);
 * 
 * sirPatrat[0] = new Square (10, MyColor.grey, 34, 3); sirPatrat[1] = new
 * Square (11, MyColor.blue , 98, 9); sirPatrat[2] = new Square (12,
 * MyColor.purple , 78, 101);
 * 
 * sirSuperCerc[0] = new SuperCircle (20, MyColor.purple, 43, 6);
 * sirSuperCerc[1] = new SuperCircle (21, MyColor.blue , 67, 92);
 * sirSuperCerc[2] = new SuperCircle (23, MyColor.grey , 45, 11);
 * 
 * Afisare(sirCerc); AfisarePatrat(sirPatrat); AfisareSuperCerc(sirSuperCerc); }
 */

