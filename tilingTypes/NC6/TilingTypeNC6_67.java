package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_67
   extends TilingType
{
   public TilingTypeNC6_67(){
      super( "NC6-67", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,100,100,100};
      paramDef = new int[]{ 50, 65, 30, 40};
      paramName = new String[]{"Aspect", "Indent", "X", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,2, 0,2,5, 0},
            {0, 0,1, 1,0,1, 1},
            {1, 5,2, 2,2,5, 1},

            {0, 2,1, 0,1,2, 0},
            {1, 5,2, 4,2,5, 0},
            {0, 0,1, 5,0,1, 1},
            {1, 5,2, 6,2,5, 1},
      };
      info = "a=c\nd=f\nA=B\nD+E=360\n(A+B+C+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;
      double w = lntotal * getParam(paramValues, 0)/100;
      double h = (lntotal - w)/2;
      double ind = ( getParam(paramValues, 1)/100 - .5 )* w;

      double y = ( getParam(paramValues, 3)/50 - 1 ) * h;
      double maxx = w/2 - ind + 2 * ind * Math.abs(y/h);
      double x = ( getParam(paramValues, 2)/50 - 1 ) * maxx;

      baseTile.setPoint(0,  -ind,  0);
      baseTile.setPoint(1,  w+ind, 0);
      baseTile.setPoint(2,  w-ind, h);
      baseTile.setPoint(3,  w/2-x, h-y);
      baseTile.setPoint(4,  w/2+x, h+y);
      baseTile.setPoint(5,  +ind, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[4].getX(5)-tiles[0].getX(0);
      offsets[3] = tiles[4].getY(5)-tiles[0].getY(0);
   }
}