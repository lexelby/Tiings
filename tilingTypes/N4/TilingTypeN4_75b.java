package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_75b
   extends TilingType
{
   public TilingTypeN4_75b(){
      super( "N4-75b: Trisected equilateral triangles", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 80, 80};
      paramName = new String[]{ "Relative Length", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,2,3, 0},
            {2, 4,3, 1,2,3, 0},
            {1, 0,2, 2,0,2, 1},
            {2, 4,3, 3,2,3, 1},
            {0, 4,3, 4,2,3, 1},

            {0, 1,0, 0,0,1, 0},
            {1, 4,3, 6,2,3, 0},
            {2, 4,3, 7,2,3, 0},
            {1, 0,2, 8,0,2, 1},
            {2, 4,3, 9,2,3, 1},
            {0, 4,3,10,2,3, 1},
      };
      info = "c=d\nA=60\nC=120\n(B+D=180)";
      labels = new int[]{0,-1,1,2,3};
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1.75;
      double f = paramValues[0]/100.;
      double h = ln * Math.sqrt(3)/2;
      double os = getParam(paramValues,1)/100;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, ln*os, 0);
      baseTile.setPoint(2, ln*f, 0);
      baseTile.setPoint(3, ln/2, h/3);
      baseTile.setPoint(4, ln*(1-f)/2, (1-f)*h );
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(0)-tiles[11].getX(1);
      offsets[3] = tiles[5].getY(0)-tiles[11].getY(1);
   }
}
