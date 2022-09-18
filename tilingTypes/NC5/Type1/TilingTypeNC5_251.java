package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_251
   extends TilingType
{
   public TilingTypeNC5_251(){
      super( "NC5-251", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 60, 40};
      paramName = new String[]{"Angle", "Indent"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,1, 0},
            {2, 1,2, 1,3,4, 1},
            {1, 2,0, 0,0,2, 0},
            {0, 1,0, 3,0,1, 0},
            {2, 1,2, 4,3,4, 1},
      };
      info = "a=d\nb=2d\nB=C\nC=E\nD+E=360\n(A+B+C=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lnad = .5;
      double lnb = 2*lnad;
      double a = getParam(paramValues, 0);
      double f = getParam(paramValues, 1)/100;
      double x4 = lnad * Math.cos(a * DEG2RAD);
      double y4 = lnad * Math.sin(a * DEG2RAD);
      double x3 = x4 + (lnad-x4)*f;
      double y3 = y4*(1-f);
      double x2 = x3 + x4;
      double y2 = y3 + y4;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, lnb, 0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(4)-tiles[5].getX(3);
      offsets[3] = tiles[2].getY(4)-tiles[5].getY(3);
   }
}
