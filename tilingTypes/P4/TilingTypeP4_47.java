package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_47
   extends TilingType
{
   public TilingTypeP4_47(){
      super( "P4-47&53", 4, SymmetryType.pg );

      paramMin = new int[]{-90,  0,  0};
      paramMax = new int[]{ 90,500,500};
      paramDef = new int[]{ 30, 29, 50};
      paramName = new String[]{ "Angle", "Relative Length", "Relative Length 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,3,2, 0},
            {0, 0,1, 0,1,2, 1},
            {0, 2,3, 2,3,2, 1},
            };
      info = "b=c\n(A+B+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = paramValues[1]/100.; //distance from middle of diagonal to third point
      double ln3 = paramValues[2]/100.; // height/base ratio of triangle for fourth point
      double x3 = .5 + ln2 * Math.cos( (90+paramValues[0]) * DEG2RAD);
      double y3 =  ln2 * Math.sin( (90+paramValues[0]) * DEG2RAD);
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,  .5, -ln3);
      baseTile.setPoint(2,   1, 0);
      baseTile.setPoint(3,  x3, y3);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(1)-tiles[2].getX(3);
      offsets[3] = tiles[1].getY(1)-tiles[2].getY(3);
   }
}
