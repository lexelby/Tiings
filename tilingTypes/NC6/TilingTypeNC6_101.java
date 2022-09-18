package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_101
   extends TilingType
{
   public TilingTypeNC6_101(){
      super( "NC6-101", 6, SymmetryType.p2);

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70,  0};
      paramName = new String[]{"Angle", "Offset"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
         {0, 0,0, 0,0,0, 0},
         {1, 5,0, 0,1,2, 1},
         {2, 2,3, 1,4,5, 0},
         {2, 4,5, 2,5,4, 0},
         {1, 4,5, 3,2,3, 1},
         {0, 1,2, 4,5,0, 0},
      };
      info = "a=c=e\nb=d=f\nA+F=180\nB+D=180\nC=F\n(E+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lna = 0.6;
      double a = getParam(paramValues,0);
      double cf = 180-a;
      
      // 4b2 = b2+c2 - 2bc cos(c)
      // 3b2 + 2bc cos(c) - c2 = 0
      // 3b2 + 2b cos(c) - 1 = 0
      double c2 = Math.cos(cf*DEG2RAD);
      double lnb = lna * (-c2 + Math.sqrt(c2*c2+3))/3;
      
      double d = Math.asin(Math.sin(cf*DEG2RAD)/2)/DEG2RAD;
      double b = 180-d;
      
      double x1 = lna;
      double y1 = 0;
      double x2 = x1 + lnb * Math.cos( (180-b) * DEG2RAD );
      double y2 = y1 + lnb * Math.sin( (180-b) * DEG2RAD );
      double x3 = x2 + lna * Math.cos( (-b-cf) * DEG2RAD );
      double y3 = y2 + lna * Math.sin( (-b-cf) * DEG2RAD );
      double x5 = 0  + lnb * Math.cos( a * DEG2RAD );
      double y5 = 0  + lnb * Math.sin( a * DEG2RAD );
      double x4 = x5 + lna;
      double y4 = y5;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = getParam(paramValues, 1)/100;
      offsets[0] = tiles[0].getX(0)-tiles[5].getX(5);
      offsets[1] = tiles[0].getY(0)-tiles[5].getY(5);
      offsets[2] = tiles[1].getX(0)-tiles[4].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[4].getY(0);
      offsets[2] += os * offsets[0];
      offsets[3] += os * offsets[1];
   }
}