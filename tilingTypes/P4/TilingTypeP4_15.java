package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_15
   extends TilingType
{
   public TilingTypeP4_15(){
      super( "P4-15", 4, SymmetryType.pgg);

      paramMin = new int[]{   0,  0,   0};
      paramMax = new int[]{ 360,100, 100};
      paramDef = new int[]{ 150, 60,  25};
      paramName = new String[]{ "Angle", "Parameter 1", "Parameter 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,2,3, 1},
            {0, 3,0, 0,1,2, 1},
            {0, 2,3, 2,0,1, 0},
            };
      info = "B+D=180\n(A+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      // tile is quadrangle with opposite angles adding to 180.
     //   This is a quadrangle that can be circumscribed by a circle
      double ang0 = paramValues[0];
      double ang1 = ang0 * (paramValues[1]+1)/102.;
      double ang2 = (360-ang0) * (paramValues[2]+1)/102.;

      // get side lengths
      double ln2 = 1.2* Math.sin( ang0/2. * DEG2RAD);   // length of diagonal
      double ln6 = 1.2* Math.sin( ang1/2. * DEG2RAD);   // p0-p3
      double ln3 = 1.2* Math.sin( (360-ang0-ang2)/2. * DEG2RAD);   // p1-p0

      double angle0d = (ang0-ang1)/2;
      double angle0 =  -ang2/2;
      double c1 = Math.cos( angle0d * DEG2RAD);
      double s1 = Math.sin( angle0d * DEG2RAD);
      double c2 = Math.cos( angle0 * DEG2RAD);
      double s2 = Math.sin( angle0 * DEG2RAD);

      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,   ln3*c2, ln3*s2 );
      baseTile.setPoint(2,   ln2, 0 );
      baseTile.setPoint(3,   ln6*c1, ln6*s1 );

   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(1)-tiles[0].getX(3);
      offsets[3] = tiles[2].getY(1)-tiles[0].getY(3);
   }
}
