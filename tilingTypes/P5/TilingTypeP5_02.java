package tilingTypes.P5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP5_02
   extends TilingType
{
   public TilingTypeP5_02(){
      super( "P5-2: Type 1", 5, SymmetryType.pg );

      paramMin = new int[]{  0,  0,-89};
      paramMax = new int[]{180,100, 89};
      paramDef = new int[]{ 60, 60, 30};
      paramName = new String[]{ "Angle", "Relative Length", "Angle 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,0, 0,2,1, 1},
            };
      info = "a=e\nb=c+d\nB+C=180\n(A+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = getParam( paramValues,1)/100.;
      double t = Math.tan( paramValues[2] * DEG2RAD);
      double c = ln2 * Math.cos( paramValues[0] * DEG2RAD);
      double s = ln2 * Math.sin( paramValues[0] * DEG2RAD);

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,   1,  0);
      baseTile.setPoint(2, 1-c,  s);
      baseTile.setPoint(3,ln2-c, s);
      baseTile.setPoint(4,(ln2-c -s*t )/2, (s +(ln2-c)*t )/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[0].getY(0);
   }
}
