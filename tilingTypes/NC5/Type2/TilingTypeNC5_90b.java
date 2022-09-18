package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_90b
   extends TilingType
{
   public TilingTypeNC5_90b(){
      super( "NC5-90b", 5, SymmetryType.cm );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,2,3, 0},
            {1, 4,0, 1,2,3, 1},
            {0, 2,3, 2,2,1, 1},
      };
      info = "a=c=d\nb=2e\nA=90\nB=90\nD=270\n(C=60)\n(E=30)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .3;
      double ln2 = ln1 * Math.sqrt(3);
      
      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1,2*ln1,  0);
      baseTile.setPoint(2,2*ln1,ln2);
      baseTile.setPoint(3,ln1/2,ln2/2);
      baseTile.setPoint(4,    0,ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(1)-tiles[0].getY(0);
   }
}
