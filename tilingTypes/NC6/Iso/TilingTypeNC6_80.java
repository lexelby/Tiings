package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_80
   extends TilingType
{
   public TilingTypeNC6_80(){
      super( "NC6-80", 6, SymmetryType.pg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,180,100,100};
      paramDef = new int[]{ 70, 70, 30, 70};
      paramName = new String[]{"Aspect", "Angle", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,5, 0,0,2, 1},
      };
      info = "a=d\nb=e\nc=f\nB+E=360\n(A+C+D+F=360)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.4;
      double ln1 = lntotal * getParam(paramValues,0)/100;
      double ln2 = lntotal - ln1;

      double x = ln1 * getParam(paramValues,2)/100;
      double y = ln2 * getParam(paramValues,3)/100;
      double a = getParam(paramValues,1);

      double c = Math.cos(a*DEG2RAD);
      double s = Math.sin(a*DEG2RAD);
      
      double x5 = ln2 * c;
      double y5 = ln2 * s;
      double x4 = x5 + ln1-(x + y * c);
      double y4 = y5 +          y * s;
      double x3 = x5 + ln1;
      double y3 = y5;
      double x2 = ln1;
      double y2 = 0;
      double x1 = x + y * c;
      double y1 =     y * s;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(5)-tiles[1].getX(0);
      offsets[3] = tiles[0].getY(5)-tiles[1].getY(0);
   }
}