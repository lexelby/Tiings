package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01n
   extends TilingType
{
   public TilingTypeN5_01n(){
      super( "N5-1n: type 1&2", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{180,100,100};
      paramDef = new int[]{ 80, 50, 50};
      paramName = new String[]{ "Angle", "Aspect", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,4, 0,4,3, 0},
            {1, 3,4, 0,1,2, 1},
            {1, 1,2, 2,2,1, 1},
      };
      info = "c=e\na+d=b\nB+C=180\nB=E\n(A+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double an = paramValues[0];

      double ln1 = 1.5*paramValues[1]/100;
      double diag = 1.5-ln1;
      double ln2 = ln1*paramValues[2]/100;
      double ln4 = ln1-ln2;
      double ln3 = calcSide(diag,ln4,an);

      double f = ln4==0 ? 180-an : calcAngle(ln4,ln3,diag);
      double b = an + an;

      double x4 = ln4 * Math.cos( (b) * DEG2RAD);
      double y4 = ln4 * Math.sin( (b) * DEG2RAD);
      double x3 = x4 + ln3 * Math.cos( (180+b+f) * DEG2RAD);
      double y3 = y4 + ln3 * Math.sin( (180+b+f) * DEG2RAD);
      double x2 = x3 + ln2;
      double y2 = y3;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[1].getX(2);
      offsets[1] = tiles[3].getY(4)-tiles[1].getY(2);
      offsets[2] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[0].getY(0);
   }
}
