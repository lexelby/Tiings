package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_253b
   extends TilingType
{
   public TilingTypeNC5_253b(){
      super( "NC5-253b", 5, SymmetryType.pg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{180,100,100};
      paramDef = new int[]{ 80, 70, 30};
      paramName = new String[]{ "Angle", "Relative Length", "Indent" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 2,3, 0,3,2, 0},
            {1, 0,1, 1,1,0, 0},
            {2, 1,0, 2,2,1, 1},
            {0, 3,2, 3,2,3, 1},
            {1, 0,1, 4,1,0, 1},
      };
      info = "a=d\nb=c+e\nA=C\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnae = 1.5;

      double a = getParam(paramValues, 0);
      double lne = lnae * getParam(paramValues, 1)/200;
      double lna = lnae - lne;
      
      double diag = calcSide(lna, lne, a);
      double b = 2 * calcAngle(lna, diag, lne);
      double maxlnd = lne / Math.sin(b*DEG2RAD) * Math.sin(a*DEG2RAD);
      double lnd = maxlnd * getParam(paramValues, 2)/100;
      double lnb = lna - lnd;

      double x4 =      lne * Math.cos(a*DEG2RAD);
      double y4 =      lne * Math.sin(a*DEG2RAD);
      double x3 = x4 + lnd * Math.cos(b*DEG2RAD);
      double y3 = y4 - lnd * Math.sin(b*DEG2RAD);
      double x2 = lna- lnb * Math.cos(b*DEG2RAD);
      double y2 =      lnb * Math.sin(b*DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, lna,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[5].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[5].getY(3)-tiles[0].getY(0);
   }
}
