package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_75d
   extends TilingType
{
   public TilingTypeN4_75d(){
      super( "N4-75d: Trisected equilateral triangles", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 80};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,1,2, 0},
            {2, 3,2, 1,1,2, 0},
            {1, 0,1, 2,0,1, 1},
            {2, 3,2, 3,1,2, 1},
            {0, 3,2, 4,1,2, 1},
      };
      info = "c=d\nA=60\nC=120\n(B+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1.75;
      double f = paramValues[0]/100.;
      double h = ln * Math.sqrt(3)/2;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, ln*f, 0);
      baseTile.setPoint(2, ln/2, h/3);
      baseTile.setPoint(3, ln*(1-f)/2, (1-f)*h );
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-(tiles[1].getX(0)+tiles[0].getX(0))/2;
      offsets[3] = tiles[3].getY(0)-(tiles[1].getY(0)+tiles[0].getY(0))/2;
   }
}
