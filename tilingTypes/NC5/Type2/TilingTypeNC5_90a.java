package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_90a
   extends TilingType
{
   public TilingTypeNC5_90a(){
      super( "NC5-90a", 6, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{ "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,3,4, 0},
            {1, 5,0, 1,3,4, 1},
            {0, 3,4, 2,3,2, 1},

            {0, 1,0, 0,0,1, 0},
            {1, 3,2, 4,3,4, 0},
            {1, 5,0, 5,3,4, 1},
            {0, 3,4, 6,3,2, 1},
      };
      info = "a=c=d\nb=2e\nA=90\nB=90\nD=270\n(C=60)\n(E=30)";
      labels = new int[]{0,-1,1,2,3,4};
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .3;
      double ln2 = ln1 * Math.sqrt(3);
      double os = 2*ln1 * getParam(paramValues,0)/100.;
      
      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1,   os,  0);
      baseTile.setPoint(2,2*ln1,  0);
      baseTile.setPoint(3,2*ln1,ln2);
      baseTile.setPoint(4,ln1/2,ln2/2);
      baseTile.setPoint(5,    0,ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(1)-tiles[3].getX(0);
      offsets[1] = tiles[7].getY(1)-tiles[3].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(0);
   }
}
