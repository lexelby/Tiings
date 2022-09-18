package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_40
   extends TilingType
{
   public TilingTypeNC5_40(){
      super( "NC5-40", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50, 50};
      paramName = new String[]{ "Aspect", "Indentation" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,4, 0,4,1, 0},
            {1, 0,4, 1,1,0, 1},
            {1, 4,3, 2,3,4, 1},
      };
      info = "c=e\na=b+d\nC+D=360\nC=E\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double width = 2.5 * paramValues[0]/100;   // width
      double height = 2.5 - width;
      double teeth = width * paramValues[1]/100;   // teeth width
      double body = width-teeth;                    // body width
      double a = Math.atan2(height/2, body)/DEG2RAD;
      double f = Math.cos(a*DEG2RAD);
      double ln1 = teeth / f;
      double ln2 = width / f;
      double ln4 = ln2-ln1;
      double ln3 = calcSide(ln1, height/2, 90+a);
      double b = paramValues[1]==0 ? 90 : a + calcAngle(ln1,ln3,height/2);
      ln1 *=f;
      ln2 *=f;
      ln3 *=f;
      ln4 *=f;

      double x1 =      ln4 * Math.cos( a * DEG2RAD);
      double y1 =    - ln4 * Math.sin( a * DEG2RAD);
      double x2 = x1 + ln3 * Math.cos( b * DEG2RAD);
      double y2 = y1 + ln3 * Math.sin( b * DEG2RAD);
      double x3 = x2 - ln1 * Math.cos( a * DEG2RAD);
      double y3 = y2 - ln1 * Math.sin( a * DEG2RAD);
      double x4 = x3 + x2-x1;
      double y4 = y3 + y2-y1;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(1)-tiles[1].getX(0);
      offsets[1] = tiles[2].getY(1)-tiles[1].getY(0);
      offsets[2] = tiles[2].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(2)-tiles[0].getY(0);
   }
}
