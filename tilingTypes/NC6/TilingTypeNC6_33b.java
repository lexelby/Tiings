package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_33b
   extends TilingType
{
   public TilingTypeNC6_33b(){
      super( "NC6-33b", 6, SymmetryType.pmg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,5, 0,0,5, 1},
            {0, 4,5, 0,5,4, 0},
            {1, 0,5, 2,0,5, 1},

            {0, 1,2, 0,1,2, 1},
            {1, 0,5, 4,0,5, 0},
            {0, 4,5, 4,5,4, 1},
            {1, 0,5, 6,0,5, 0},
      };
      info = "b=c\nd=e=f\n2A+B=360\nB+C=180\nC+D=180\nD+E=360\n(2F=D)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 0.35;
      double w = lntotal * getParam(paramValues, 0)/100;
      double h = lntotal - w;

      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1,  3*w,-3*h);
      baseTile.setPoint(2,  6*w,  0);
      baseTile.setPoint(3,  4*w,2*h);
      baseTile.setPoint(4,  2*w,  0);
      baseTile.setPoint(5,    0,2*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[6].getX(1)-tiles[2].getX(1);
      offsets[3] = tiles[6].getY(1)-tiles[2].getY(1);
   }
}