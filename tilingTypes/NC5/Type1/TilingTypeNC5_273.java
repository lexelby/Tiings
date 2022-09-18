package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_273
   extends TilingType
{
   public TilingTypeNC5_273(){
      super( "NC5-273", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{ 90,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,0,4, 0},
            {1, 1,4, 1,4,1, 0},
            {0, 4,0, 2,0,4, 0},
            {2, 1,0, 0,3,4, 0},
            {2, 1,4, 4,4,1, 0},
      };
      info = "b=2c\nc=e\nA+C=180\nC+D=360\n(A+B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lna = 0.9;
      double lnc = lna * getParam(paramValues,1)/100;
      double lnbd = lna /2;
      double a = getParam(paramValues,0);
      double lne = lnc + 2 * lna * Math.cos(a*DEG2RAD);
      
      double diag = calcSide(lna,lne,a);
      double b1 = calcAngle(diag,lna,lne);
      double b2 = calcAngle(diag,lna,lnc);
      double b = b1+b2;
      double dx = lnbd*Math.cos(b*DEG2RAD);
      double dy = lnbd*Math.sin(b*DEG2RAD);
      
      double x4 = lne*Math.cos(a*DEG2RAD);
      double y4 = lne*Math.sin(a*DEG2RAD);
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, lna-dx, dy);
      baseTile.setPoint(3,  x4+dx, y4-dy);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(1)-tiles[3].getX(3);
      offsets[1] = tiles[5].getY(1)-tiles[3].getY(3);
      offsets[2] = tiles[0].getX(4)-tiles[0].getX(1);
      offsets[3] = tiles[0].getY(4)-tiles[0].getY(1);
   }

}
