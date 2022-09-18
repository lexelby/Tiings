package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_262
   extends TilingType
{
   public TilingTypeNC5_262(){
      super( "NC5-262", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,4,0, 0},
            {2, 1,0, 0,3,4, 0},
            {1, 3,2, 1,2,3, 0},
            {0, 0,4, 3,4,0, 0},
            {2, 1,0, 4,3,4, 0},
      };
      info = "c=d\nb=2c+e\nB=90\nC=90\nD=270\n(A=45)\n(E=45)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double ln1 = ln * getParam(paramValues, 0)/100;
      double ln2 = ln - ln1;

      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, 2*ln1+ln2,   0);
      baseTile.setPoint(2, 2*ln1+ln2, ln1);
      baseTile.setPoint(3,   ln1+ln2, ln1);
      baseTile.setPoint(4,   ln1+ln2, ln1+ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(1);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(1);
      offsets[2] = tiles[5].getX(4)-tiles[2].getX(0);
      offsets[3] = tiles[5].getY(4)-tiles[2].getY(0);
   }
}
