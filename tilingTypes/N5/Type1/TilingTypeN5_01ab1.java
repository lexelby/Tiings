package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ab1
   extends TilingType
{
   public TilingTypeN5_01ab1(){
      super( "N5-1ab1", 5, SymmetryType.pg );

      paramMin = new int[]{  0};
      paramMax = new int[]{270};
      paramDef = new int[]{120};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,2,1, 1},
            {0, 0,1, 1,2,1, 1},
            {1, 1,0, 2,2,1, 0},
      };
      info = "a=d=e\nb=c+d\nB+C=180\nC=D\n(A+D+E=360)\n(E=3B)";
   }

   public void recalcBase(double[] paramValues) {
      double e = getParam(paramValues, 0);
      double b = e/3;
      double a = 180-(b+e)/2;
      
      double ln1 = 1;
      double diag = 2 * ln1 * Math.sin(e/2 * DEG2RAD);
      double ln2 = diag/2 / Math.sin(b/2 * DEG2RAD);
      double f = 1/(ln1+ln2);
      ln1 *= f;
      ln2 *= f;

      double x4 =      ln1*Math.cos( a * DEG2RAD);
      double y4 =      ln1*Math.sin( a * DEG2RAD);
      double x3 = x4 + ln1*Math.cos( (a+e-180) * DEG2RAD);
      double y3 = y4 + ln1*Math.sin( (a+e-180) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1+ln2,  0);
      baseTile.setPoint(2, x3+ln1, y3);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(2)-tiles[0].getY(0);
   }
}
