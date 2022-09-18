package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_214
   extends TilingType
{
   public TilingTypeNC5_214(){
      super( "NC5-214", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,180,100};
      paramDef = new int[]{ 30, 80, 50};
      paramName = new String[]{ "Aspect", "Angle", "Indent"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {1, 4,1, 1,1,4, 0},
            {0, 1,0, 2,0,1, 0},
      };
      info = "c=e\nC=E\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double lna = lnt * getParam(paramValues,0)/100;
      double lnb = lnt - lna;
      double lnd = lna * getParam(paramValues,2)/100;
      double a = getParam(paramValues,1);

      double c = Math.cos(a * DEG2RAD);
      double s = Math.sin(a * DEG2RAD);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnb, 0);
      baseTile.setPoint(2,  (lnb+(lna+lnd)*c)/2, (lna+lnd)*s/2);
      baseTile.setPoint(3,  (lnb+(lna-lnd)*c)/2, (lna-lnd)*s/2);
      baseTile.setPoint(4,  lna*c, lna*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[3].getX(1);
      offsets[1] = tiles[0].getY(2)-tiles[3].getY(1);
      offsets[2] = tiles[0].getX(3)-tiles[3].getX(4);
      offsets[3] = tiles[0].getY(3)-tiles[3].getY(4);
   }
}
