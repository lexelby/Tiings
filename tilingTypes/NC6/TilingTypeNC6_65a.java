package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_65a
   extends TilingType
{
   public TilingTypeNC6_65a(){
      super( "NC6-65a", 7, SymmetryType.pmg );

      paramMin = new int[]{  0,  0,  0,  0,  0,  0};
      paramMax = new int[]{100,180,100,100,100,100};
      paramDef = new int[]{ 50, 80, 45, 40, 35,  0};
      paramName = new String[]{"Aspect", "Angle", "Relative Length", "X", "Y", "Offset"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 6,3, 0,3,6, 0},
            {1, 0,2, 1,0,2, 1},
            {0, 3,6, 2,6,3, 1},

            {0, 1,0, 0,0,1, 0},
            {1, 6,3, 4,3,6, 0},
            {1, 0,2, 5,0,2, 1},
            {0, 3,6, 6,6,3, 1},
      };
      info = "d=f\nA+B=180\nD+E=360\n(C+D=180)";
      labels = new int[]{0,-1,1,2,3,4,5};
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;
      double w = lntotal * getParam(paramValues, 0)/100;
      double h = lntotal - w;
      double ln1 = h * getParam(paramValues, 2)/100;
      double ln2 = h - ln1;

      double a = getParam(paramValues, 1);
      double x = getParam(paramValues, 3)/100 * w;
      double y = getParam(paramValues, 4)/100 * h;
      double os = getParam(paramValues, 5)/100 * w;

      double c = Math.cos(a * DEG2RAD);
      double s = Math.sin(a * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  os, 0);
      baseTile.setPoint(2,  w, 0);
      baseTile.setPoint(3, w+c*ln1, s*ln1);
      baseTile.setPoint(4, x+c*y, s*y);
      baseTile.setPoint(5, w-x + c*(h-y), s*(h-y));
      baseTile.setPoint(6, c*ln2, s*ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(1);
   }
}