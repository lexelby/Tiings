package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_10
   extends TilingType
{
   public TilingTypeP4_10(){
      super( "P4-10&32&34: Strips, alternating, offset", 5, SymmetryType.pgg);

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{180,100,100};
      paramDef = new int[]{ 80, 40, 65};
      paramName = new String[]{ "Angle", "Aspect", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {0, 0,4, 1,4,3, 1},
            {0, 1,2, 2,2,1, 1},
            };
      labels = new int[]{0,1,2,3,-1};
      info = "A+D=180\n(B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2*paramValues[1]/100.;  // vertical side
      double w = 2-ln2;
      double t = w*Math.tan( (paramValues[0]-90)* DEG2RAD);
      double f = paramValues[2]/100.;  // diagonal side ratio

      baseTile.setPoint(0,      0, 0);
      baseTile.setPoint(1,    w*f, -t*f);
      baseTile.setPoint(2,w*(1-f), ln2-t*(1-f) );
      baseTile.setPoint(3,      0, ln2);
      baseTile.setPoint(4,      0, ln2/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[0].getY(0);
   }
}
