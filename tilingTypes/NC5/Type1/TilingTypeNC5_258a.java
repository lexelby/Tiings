package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_258a
   extends TilingType
{
   public TilingTypeNC5_258a(){
      super( "NC5-258a", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 40, 40};
      paramName = new String[]{ "Angle", "Indent" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,1, 0},
            {2, 1,2, 1,3,4, 1},
            {1, 4,3, 0,3,4, 0},
            {0, 1,0, 3,0,1, 0},
            {2, 1,2, 4,3,4, 1},
      };
      info = "b=a+d\nc=2e\nB=C\nC=E\nD+E=360\n(A+B+C=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln1 = 1.0;
      double ln2 = ln1 *2* getParam(paramValues,1)/300;
      double a = getParam(paramValues,0);
      double c = Math.cos(a*DEG2RAD);
      double s = Math.sin(a*DEG2RAD);
      
      double x4 = (ln1-ln2)*c;
      double y4 = (ln1-ln2)*s;
      double x3 = ln1/3 + (ln1*2/3-ln2)*c;
      double y3 =         (ln1*2/3-ln2)*s;
      double x2 = ln1/3 + ln1*2/3*c;
      double y2 =         ln1*2/3*s;
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln1, 0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(2)-tiles[2].getX(3);
      offsets[1] = tiles[5].getY(2)-tiles[2].getY(3);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(0);
   }

}
