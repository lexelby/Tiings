package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_167
   extends TilingType
{
   public TilingTypeNC5_167(){
      super( "NC5-167", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 60};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {0, 1,3, 0,0,3, 0},
            {0, 4,0, 2,0,4, 0},
      };
      info = "a=c\nd=e\nD=90\nA+E=180\nC+E=360\n(A+B=90)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 0.6;
      double d = w * getParam(paramValues, 0)/100;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, w+w, 0);
      baseTile.setPoint(2, w, w-d);
      baseTile.setPoint(3, w, w);
      baseTile.setPoint(4, w-d, w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(3)-tiles[1].getX(3);
      offsets[3] = tiles[3].getY(3)-tiles[1].getY(3);
   }
}
