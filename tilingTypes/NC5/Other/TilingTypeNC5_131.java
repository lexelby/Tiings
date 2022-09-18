package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_131
   extends TilingType
{
   public TilingTypeNC5_131(){
      super( "NC5-131", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 60};
      paramName = new String[]{"Aspect"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,0,1, 1},
            {1, 0,1, 1,1,0, 1},
            {0, 0,1, 2,4,0, 0},

            {0, 2,3, 0,3,4, 1},
            {1, 4,0, 4,0,1, 0},
            {1, 0,1, 5,1,0, 0},
            {0, 0,1, 6,4,0, 1},
      };
      info = "d=e\na=c+d\nb=a+c\nA+B=180\nB+C=180\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 0.6;
      double h1= lntotal * getParam(paramValues, 0)/100;
      double a = lntotal - h1;
      double b = Math.sqrt(a*a+h1*h1);
      double h2= h1 * a/b;
      double w2 = a * a/b;
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, 2*a+b, 0);
      baseTile.setPoint(2, 2*a+b+w2, h2);
      baseTile.setPoint(3, 2*a+w2, h2);
      baseTile.setPoint(4, a+w2, h1+h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[7].getX(2)-tiles[3].getX(3);
      offsets[3] = tiles[7].getY(2)-tiles[3].getY(3);
   }
}
