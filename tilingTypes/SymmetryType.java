package tilingTypes;

public enum SymmetryType {
   p6m ("p6m / *632"),
   p6  ("p6 / 632"),
   p4m ("p4m / *442"),
   p4g ("p4g / 4*2"),
   p4  ("p4 / 442"),
   p31m("p31m / 3*3"),
   p3m1("p3m1 / *333"),
   p3  ("p3 / 333"),
   cmm ("cmm / 2*22"),
   pmm ("pmm / *2222"),
   pmg ("pmg / 22*"),
   pgg ("pgg / 22x"),
   p2  ("p2 / 2222"),
   cm  ("cm / *x"),
   pm  ("pm / **"),
   pg  ("pg / xx"),
   p1  ("p1 / o");
   private  final String name;
   private SymmetryType(String n){ name = n; }
   public String toString(){ return name; }
}
