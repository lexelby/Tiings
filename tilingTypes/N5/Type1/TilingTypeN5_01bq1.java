package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bq1
   extends TilingType
{
   public TilingTypeN5_01bq1(){
      super( "N5-1bq1", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 20};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 3,2, 0,2,3, 0},
            {2, 1,2, 1,1,0, 0},
            {1, 0,1, 0,1,0, 0},
            {0, 3,2, 3,2,3, 0},
            {2, 1,2, 4,1,0, 0},
      };
      info = "b=c\na=2b+e\nA=90\nB=90\nE=90\n(C+D=270)";
   }

   public void recalcBase(double[] paramValues) {
      double lna = .5;
      double lnd = lna*paramValues[0]/100.;
      double lne = lna+lna+lnd;
      double f = lne;
      lna /=f;
      lne /=f;
      lnd /=f;

      baseTile.setPoint(0, 0,   0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, lna, lna);
      baseTile.setPoint(3, lnd, lne);
      baseTile.setPoint(4, 0,   lne);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[2].getX(4)-tiles[5].getX(0);
      offsets[3] = tiles[2].getY(4)-tiles[5].getY(0);
   }
}
