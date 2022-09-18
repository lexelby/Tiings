package tilingTypes.N5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_15
   extends TilingType
{
   public TilingTypeN5_15(){
      super( "N5-15: Mann, McLoud-Mann, Von Derau, 2015", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,3,4, 1},
            {2, 2,3, 1,2,3, 0},
            {2, 0,1, 2,3,4, 1},
            {1, 2,3, 3,2,3, 0},
            {0, 3,4, 4,1,2, 1},
            
            {0, 2,1, 0,1,2, 0},
            {1, 1,2, 6,3,4, 1},
            {2, 2,3, 7,2,3, 0},
            {2, 0,1, 8,3,4, 1},
            {1, 2,3, 9,2,3, 0},
            {0, 3,4,10,1,2, 1},
      };
      info = "a=c=e\nb=2a\nA=150\nB=60\nC=135\nD=105\n(E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .2;
      double ln2 = ln1*Math.sqrt(3);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln1*4, 0);
      baseTile.setPoint(2, ln1*3, ln2);
      baseTile.setPoint(3, -ln2+ln1, ln1+ln2);
      baseTile.setPoint(4, -ln2, ln1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(1);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(1);
      offsets[2] = tiles[11].getX(1)-tiles[5].getX(2);
      offsets[3] = tiles[11].getY(1)-tiles[5].getY(2);
   }
}
