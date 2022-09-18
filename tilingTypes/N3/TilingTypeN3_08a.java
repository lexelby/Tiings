package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_08a
   extends TilingType
{
   public TilingTypeN3_08a(){
      super( "N3-8a", 3, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 40};
      paramName = new String[]{ "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 0,2, 1,0,2, 0},
            {1, 0,1, 2,0,1, 1},
      };
      info = "A=90\n(B+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.5 * paramValues[0]/100.;
      double w = 1.5-h;
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = paramValues[1]/100.;
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(1);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(1);
      offsets[2] = (os*tiles[0].getX(2)+(1-os)*tiles[0].getX(1))-tiles[2].getX(1);
      offsets[3] = (os*tiles[0].getY(2)+(1-os)*tiles[0].getY(1))-tiles[2].getY(1);
   }
}
