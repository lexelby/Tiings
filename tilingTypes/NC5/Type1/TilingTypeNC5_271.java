package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_271
   extends TilingType
{
   public TilingTypeNC5_271(){
      super( "NC5-271", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 3,4, 0,4,3, 0},
            {1, 0,4, 1,0,1, 0},
            {1, 1,2, 2,2,1, 0},
            {0, 0,1, 3,0,4, 0},
            {2, 4,3, 4,3,4, 0},
      };
      info = "a=b\nc+d=2a\nA=90\nB=90\nC=270\n(D+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 0.5;
      double ln2 = ln1 * getParam(paramValues,0)/100;
      double ln3 = 2*ln1 - ln2;

      baseTile.setPoint(0,  0, 0 );
      baseTile.setPoint(1,  ln1, 0 );
      baseTile.setPoint(2,  ln1, ln2 );
      baseTile.setPoint(3,  ln1+ln3, ln2 );
      baseTile.setPoint(4,  0, ln1 );
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[5].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(4);
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(4);
   }
}
