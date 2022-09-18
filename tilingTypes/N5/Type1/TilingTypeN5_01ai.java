package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ai
   extends TilingType
{
   public TilingTypeN5_01ai(){
      super( "N5-1ai", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 65};
      paramName = new String[]{ "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,2,3, 0},
            {0, 4,3, 1,2,3, 0},
            {1, 4,3, 2,2,3, 0},
            };
      info = "b=a+c\nd=e\nA=90\nB=90\nD=90\n(C+E=270)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.;
      double h1 = w * paramValues[0]/100.;
      double h2 = w - h1;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  w, h1);
      baseTile.setPoint(3, h2,  w);
      baseTile.setPoint(4,  0, h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[3].getX(0);
      offsets[1] = tiles[1].getY(1)-tiles[3].getY(0);
      offsets[2] = tiles[2].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(4)-tiles[0].getY(0);
   }
}
