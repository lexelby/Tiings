package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_200
   extends TilingType
{
   public TilingTypeNC5_200(){
      super( "NC5-200", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 30, 50};
      paramName = new String[]{ "Aspect", "Indent"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 4,1, 1,1,4, 1},
            {0, 0,1, 2,0,1, 0},
      };
      info = "c=e\nA=90\nC=E\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double lna = lnt * getParam(paramValues,0)/100;
      double lnb = lnt - lna;
      double lnd = lna * getParam(paramValues,1)/100;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnb, 0);
      baseTile.setPoint(2,  lnb/2, (lna+lnd)/2);
      baseTile.setPoint(3,  lnb/2, (lna-lnd)/2);
      baseTile.setPoint(4,  0, lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[3].getX(1);
      offsets[1] = tiles[0].getY(2)-tiles[3].getY(1);
      offsets[2] = tiles[0].getX(3)-tiles[3].getX(4);
      offsets[3] = tiles[0].getY(3)-tiles[3].getY(4);
   }
}
