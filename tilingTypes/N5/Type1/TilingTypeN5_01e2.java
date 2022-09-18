package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01e2
   extends TilingType
{
   public TilingTypeN5_01e2(){
      super( "N5-1e2", 5, SymmetryType.pgg);

      paramMin = new int[]{  0,  0,-89};
      paramMax = new int[]{180,100, 89};
      paramDef = new int[]{ 60, 60, 30};
      paramName = new String[]{ "Angle", "Relative Length", "Angle 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,2,1, 1},
            {1, 4,3, 1,3,4, 1},
            {0, 2,1, 2,1,0, 0},
            
            {0, 4,0, 0,3,4, 1},
            {1, 1,0, 4,2,1, 0},
            {1, 4,3, 5,3,4, 0},
            {0, 2,1, 6,1,0, 1},
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
      offsets[0] = tiles[3].getX(4)-tiles[7].getX(0);
      offsets[1] = tiles[3].getY(4)-tiles[7].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[0].getY(0);
   }
}
