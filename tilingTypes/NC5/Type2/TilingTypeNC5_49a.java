package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_49a
   extends TilingType
{
   public TilingTypeNC5_49a(){
      super( "NC5-49a: 60-90-150-30-210, Bob Jenkins", 5, SymmetryType.p4 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {3, 0,0, 0,0,0, 0},

            {0, 0,4, 0,2,3, 0},
            {1, 2,0, 1,2,4, 0},
            {2, 2,0, 2,2,4, 0},
            {0, 2,0, 3,2,4, 0},
            {1, 2,0, 4,2,4, 0},
            {2, 2,0, 5,2,4, 0},
            {0, 2,0, 6,2,4, 0},
            {1, 2,0, 7,2,4, 0},
            {2, 2,0, 8,2,4, 0},
            {0, 2,0, 9,2,4, 0},
            {1, 2,0,10,2,4, 0},
            {2, 2,0,11,2,4, 0},
            
            {3, 2,3, 4,0,4, 0},
            {3, 2,3, 7,0,4, 0},
            {3, 2,3,10,0,4, 0},
      };
      info = "a=b=c=d=e\nA=90\nB=150\nC=30\nD=210\n(E=60)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double h = ln * Math.sqrt(3)/2;
      baseTile.setPoint(0,   0,    0);
      baseTile.setPoint(1,  ln,    0);
      baseTile.setPoint(2,ln+h, ln/2);
      baseTile.setPoint(3,   h, ln/2);
      baseTile.setPoint(4,   0,   ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[13].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[13].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[15].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[15].getY(0)-tiles[0].getY(0);
   }
}
