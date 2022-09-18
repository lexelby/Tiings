package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01i
   extends TilingType
{
   public TilingTypeN5_01i(){
      super( "N5-1i: type 1&2", 5, SymmetryType.p2 );

      paramMin = new int[]{ 60};
      paramMax = new int[]{120};
      paramDef = new int[]{ 72};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,2,3, 0},
            {1, 3,2, 1,2,3, 0},
            {0, 3,2, 2,3,4, 0},
      };
      info = "c=d=e\nA+B=180\nA=D=E\n(C+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double f = paramValues[0];
      double c1 = Math.cos( f * DEG2RAD);
      double c2 = Math.cos( (f+f) * DEG2RAD);
      double c3 = Math.cos( (f+f+f) * DEG2RAD);
      double s1 = Math.sin( f * DEG2RAD);
      double s2 = Math.sin( (f+f) * DEG2RAD);
      double s3 = Math.sin( (f+f+f) * DEG2RAD);

      double w = (s3+s2)*c1/s1;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln*(w-c2-c3),    0);
      baseTile.setPoint(2, ln*(w-c1-c2-c3), ln*s1);
      baseTile.setPoint(3, ln*(w-c1-c2),    ln*(s1-s3));
      baseTile.setPoint(4, ln*(w-c1),       ln*(s1-s2-s3));
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[2].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[2].getY(0);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(0);
   }
}
