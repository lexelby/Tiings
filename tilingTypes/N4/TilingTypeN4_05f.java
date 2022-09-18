package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_05f
   extends TilingType
{
   public TilingTypeN4_05f(){
      super( "N4-5f", 4, SymmetryType.p2 );

      paramMin = new int[]{  0,   0};
      paramMax = new int[]{180, 100};
      paramDef = new int[]{120,  55};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,1,2, 1},
            {2, 3,2, 1,2,3, 1},

            {0, 3,2, 0,2,3, 0},
            {1, 1,2, 3,1,2, 1},
            {2, 3,2, 4,2,3, 1},
      };
      info = "a=b\nA+2B=360\n(A+B+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 1.5*getParam( paramValues,1)/100.;  // length of third side
      double ln1 = 1.5 - ln2;
      double d = paramValues[0];
      double c = 360-d-d;

      double x2 = ln1 - ln2 * Math.cos( d * DEG2RAD);
      double y2 = ln2 * Math.sin( d * DEG2RAD);
      double x3 = ln1*Math.cos( c * DEG2RAD);
      double y3 = ln1*Math.sin( c * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(1)-tiles[5].getX(2);
      offsets[1] = tiles[2].getY(1)-tiles[5].getY(2);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(0);
   }
}
