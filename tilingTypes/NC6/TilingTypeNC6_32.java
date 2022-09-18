package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_32
   extends TilingType
{
   public TilingTypeNC6_32(){
      super( "NC6-32", 6, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 5,4, 0,4,5, 0},
            {1, 0,5, 0,0,5, 1},
            {1, 0,5, 1,0,5, 1},
      };
      info = "c=d=e=f\nA=90\nC+D=180\nD+E=360\nD=2F\n(B=90+F)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 0.6;
      double w = lntotal * getParam(paramValues, 0)/100;
      double h = lntotal - w;

      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1,  2*w,  0);
      baseTile.setPoint(2,  3*w,  h);
      baseTile.setPoint(3,  2*w,2*h);
      baseTile.setPoint(4,    w,  h);
      baseTile.setPoint(5,    0,2*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[2].getX(2);
      offsets[1] = tiles[0].getY(1)-tiles[2].getY(2);
      offsets[2] = tiles[0].getX(1)-tiles[3].getX(1);
      offsets[3] = tiles[0].getY(1)-tiles[3].getY(1);
   }
}