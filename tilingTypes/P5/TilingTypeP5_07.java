package tilingTypes.P5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP5_07
   extends TilingType
{
   public TilingTypeP5_07(){
      super( "P5-7: Type 1", 5, SymmetryType.pgg );

      paramMin = new int[]{-90,  0,-90, -100};
      paramMax = new int[]{ 90,100, 90,  500};
      paramDef = new int[]{ 30, 45,-40,   50};
      paramName = new String[]{ "Angle", "Relative Length", "Point Angle", "Point Distance" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,1,2, 1},
            {0, 4,0, 1,0,4, 1},
            {0, 2,3, 2,1,2, 0},
            };
      info = "d=b+c\nB+C=180\n(A+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double w1 = paramValues[1]/100.;
      double w2 = 1-w1;
      double ln3 = (w1+w2)*paramValues[3]/100.;  // horizontal distance of asymmetric point
      double ln4 = ln3 * Math.tan( paramValues[2] * DEG2RAD); // offset asymmetric point
      double t = Math.tan( paramValues[0] * DEG2RAD); // relative offset body

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, w1,  -t*w1);
      baseTile.setPoint(2,w1+w2, t*(w2-w1));
      baseTile.setPoint(3,  0, 2*w2*t);
      baseTile.setPoint(4, -ln3, w2*t-ln4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[0].getY(0);
   }
}
