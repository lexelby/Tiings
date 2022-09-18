package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_70
   extends TilingType
{
   public TilingTypeNC6_70(){
      super( "NC6-70", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0,  0,  0};
      paramMax = new int[]{100,360,360,100,100};
      paramDef = new int[]{ 40,100, 95, 70, 30};
      paramName = new String[]{"Relative Length", "Angle 1", "Angle 2", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,2, 0,2,5, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 5,2, 2,2,5, 0},

            {0, 0,1, 0,1,2, 1},
            {1, 5,2, 4,2,5, 1},
            {1, 1,0, 5,0,1, 1},
            {0, 5,2, 6,2,5, 1},
      };
      info = "b=c\nd=f\nD+E=360\n(A+B+C+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.2;
      double ln1 = lntotal * getParam(paramValues, 0)/100;
      double ln2 = lntotal - ln1;

      double a = getParam(paramValues, 1);
      double b = getParam(paramValues, 2);

      double x5 =  ln1 * Math.cos(a * DEG2RAD);
      double y5 =  ln1 * Math.sin(a * DEG2RAD);
      double x1 =  ln2;
      double y1 =  0;
      double x2 =  x1 + ln2 * Math.cos((180-b) * DEG2RAD);
      double y2 =  y1 + ln2 * Math.sin((180-b) * DEG2RAD);

      double x = getParam(paramValues, 3)/100;
      double y = 2-getParam(paramValues, 4)/50;
      
      double px = x5*x + x2*(1-x);
      double py = y5*x + y2*(1-x);
      double qx =  x1*(1-x);
      double qy =  y1*(1-x);
      
      double x4 = px*y+qx*(1-y);
      double y4 = py*y+qy*(1-y);
      double x3 = x2 + (x5-x4);
      double y3 = y2 + (y5-y4);
      
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
      offsets[2] = tiles[7].getX(1)-tiles[3].getX(0);
      offsets[3] = tiles[7].getY(1)-tiles[3].getY(0);
   }
}