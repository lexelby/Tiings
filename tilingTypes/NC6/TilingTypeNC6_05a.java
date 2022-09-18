package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_05a
   extends TilingType
{
   public TilingTypeNC6_05a(){
      super( "NC6-5a", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 20};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,2,3, 0},
            {1, 4,5, 1,2,3, 1},
            {0, 2,3, 2,2,1, 1},

            {0, 1,0, 0,0,1, 0},
            {1, 2,1, 4,2,3, 0},
            {1, 4,5, 5,2,3, 1},
            {0, 2,3, 6,2,1, 1},
      };
      info = "a=b=e\nc=d=f\nB=F\nB+D=360\nF+A+B=360\n(C+E=F)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1;
      double w = ln * Math.sqrt(3)/2;
      double h = ln/2;
      double c = ln * getParam(paramValues, 0)/100 * 2/Math.sqrt(3);
      double wc = c/2;
      double hc = c*Math.sqrt(3)/2;
      
      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, w-c,  -h);
      baseTile.setPoint(2,   w,  -h);
      baseTile.setPoint(3,w-wc,hc-h);
      baseTile.setPoint(4,   w,   h);
      baseTile.setPoint(5, w-c,   h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(2);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(2);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(1);
   }
}