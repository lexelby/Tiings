package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_38a
   extends TilingType
{
   public TilingTypeNC6_38a(){
      super( "NC6-38a", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 70};
      paramName = new String[]{"Aspect", "Relative height"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,1,2, 1},
            {1, 2,1, 1,1,2, 1},
            {0, 1,2, 2,0,1, 0},
      };
      info = "b=c\na=e=f\nF=2D\nE+F=360\nB+2C=360\n(A+D=C)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double w = lntotal * getParam(paramValues, 0)/100;
      double h = lntotal - w;
      double h1 = h * getParam(paramValues, 1)/100;
      double h2 = h-h1;

      baseTile.setPoint(0,     0,  0);
      baseTile.setPoint(1,   w/2, -h1);
      baseTile.setPoint(2,   w  ,  0);
      baseTile.setPoint(3,   w  , h2);
      baseTile.setPoint(4, 2*w/3,  0);
      baseTile.setPoint(5,   w/3, h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(5)-tiles[0].getX(1);
      offsets[1] = tiles[0].getY(5)-tiles[0].getY(1);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(0);
   }
}