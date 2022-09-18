package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_69c
   extends TilingType
{
   public TilingTypeNC5_69c(){
      super( "NC5-69c", 5, SymmetryType.pg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,2,3, 1},
            {1, 0,1, 0,4,3, 0},
            {0, 2,3, 2,2,3, 1},
      };
      info = "a=c\nb=2e\nA=30\nB=150\nC=60\nD=90\n(E=210)";
   }

   public void recalcBase(double[] paramValues) {
      double h = Math.sqrt(3)/2;
      double ln1 = paramValues[0]/100.;
      double ln2 = 1-ln1;

      baseTile.setPoint(0, 0,           0);
      baseTile.setPoint(1, 2*ln2,       0);
      baseTile.setPoint(2, ln1*h+2*ln2, ln1/2);
      baseTile.setPoint(3, ln1*h+ln2/2, ln1/2+ln2*h);
      baseTile.setPoint(4, ln1*h,       ln1/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(0);
      offsets[2] = (tiles[3].getX(1)+tiles[3].getX(0))/2-tiles[0].getX(0);
      offsets[3] = (tiles[3].getY(1)+tiles[3].getY(0))/2-tiles[0].getY(0);
   }
}
