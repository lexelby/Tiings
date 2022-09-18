package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_64
   extends TilingType
{
   public TilingTypeNC6_64(){
      super( "NC6-64", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,100,360,100};
      paramDef = new int[]{ 65, 30,140, 35};
      paramName = new String[]{"Relative Length 1", "Relative Length 2", "Angle", "Relative Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 4,5, 0,5,4, 0},
            {0, 5,0, 1,0,5, 0},
            {1, 4,5, 2,5,4, 0},

            {1, 5,0, 1,2,3, 1},
            {0, 4,5, 4,5,4, 1},
            {0, 5,0, 5,0,5, 1},
            {1, 4,5, 6,5,4, 1},
      };
      info = "a=d\nc=e\nE+F=D\nC+D=360\n(A+B+D=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;
      double ln1 = lntotal * getParam(paramValues, 0)/100;
      double ln23 = lntotal - ln1;
      double ln2 = ln23 * getParam(paramValues, 1)/100;
      double ln3 = ln23 - ln2;

      double c = getParam(paramValues, 2);
      double a = getParam(paramValues, 3)/100 * c;
      double b = c-a;

      double x1 = ln1;
      double y1 = 0;
      double x2 = x1 + ln2 * Math.cos((180-b)*DEG2RAD);
      double y2 = y1 + ln2 * Math.sin((180-b)*DEG2RAD);
      double x3 = x2 + ln3 * Math.cos((-b-c)*DEG2RAD);
      double y3 = y2 + ln3 * Math.sin((-b-c)*DEG2RAD);
      double x4 = x3 + x2-x1;
      double y4 = y3 + y2-y1;
      double x5 = ln3 * Math.cos(a*DEG2RAD);
      double y5 = ln3 * Math.sin(a*DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[6].getX(3);
      offsets[3] = tiles[3].getY(0)-tiles[6].getY(3);
   }
}