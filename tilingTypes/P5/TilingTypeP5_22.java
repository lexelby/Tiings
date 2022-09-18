package tilingTypes.P5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP5_22
   extends TilingType
{
   public TilingTypeP5_22(){
      super( "P5-22: Type 2", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{180,100,180};
      paramDef = new int[]{ 90, 65, 20};
      paramName = new String[]{ "Angle 1", "Relative Length", "Angle 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,0,1, 1},
            {0, 3,4, 0,1,2, 1},
            {0, 1,2, 1,3,4, 0},
            };
      info = "b=d\nc=e\nB+D=180\n(A+C+E=360)";
   }

   public void recalcBase(double[] paramValues) {

      double ln1 = paramValues[1]/100.;  // side 1
      double ln2 = 1-ln1;                  // side 2
      // get diagonals
      // ln1^2+ln2^2 - 2*ln1*ln2*cosx = ln3^2
      double ln3 = calcSide(ln1,ln2,paramValues[0]);
      double ln4 = calcSide(ln1,ln2,180-paramValues[0]);
      // get angles opposite ln2 side, between ln1 side and diagonal
      double s = Math.sin(paramValues[0] * DEG2RAD);
      double c = Math.cos(paramValues[0] * DEG2RAD);
      double a3,a4;
      if( ln1>ln2 ) {
         a3 = Math.asin( ln2 * s / ln3 ) / DEG2RAD;
         a4 = Math.asin( ln2 * s / ln4 ) / DEG2RAD;
      } else {
         a3 = 180 - paramValues[0] - Math.asin( ln1 * s / ln3 ) / DEG2RAD;
         a4 = paramValues[0] - Math.asin( ln1 * s / ln4 ) / DEG2RAD;
      }
      
      double x2 = ln1 + ln2 * c;
      double y2 = ln2 * s;
      double x3 = x2 - ln1 * Math.cos( (a4 - paramValues[2] -a3) * DEG2RAD);
      double y3 = y2 - ln1 * Math.sin( (a4 - paramValues[2] -a3) * DEG2RAD);
      double x4 = x2 - ln3 * Math.cos( (a4 - paramValues[2]) * DEG2RAD);
      double y4 = y2 - ln3 * Math.sin( (a4 - paramValues[2]) * DEG2RAD);

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln1,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[1].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[1].getY(0);
   }
}
