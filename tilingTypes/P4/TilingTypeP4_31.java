package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_31
   extends TilingType
{
   public TilingTypeP4_31(){
      super( "P4-31: Strips, alternating", 4, SymmetryType.pmg);

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{180,100,100};
      paramDef = new int[]{ 75, 40, 70};
      paramName = new String[]{ "Angle", "Aspect", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {0, 0,3, 1,0,3, 1},
            {0, 1,2, 2,2,1, 1},
            };
      info = "A+D=180\n(B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 2*paramValues[1]/100.;
      double ln2 = 2-w;
      double t = w * Math.tan( (paramValues[0]-90) * DEG2RAD);
      double f = paramValues[2]/100.;  // diagonal side ratio

      baseTile.setPoint(0,      0, 0);
      baseTile.setPoint(1,    w*f, -t*f);
      baseTile.setPoint(2,w*(1-f), ln2-t*(1-f) );
      baseTile.setPoint(3,      0, ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[0].getY(0);
   }
}
