package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_201
   extends TilingType
{
   public TilingTypeNC5_201(){
      super( "NC5-201", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Aspect", "Indent"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 3,2, 1,2,3, 1},
            {0, 0,1, 2,0,1, 0},
      };
      info = "e=2c\nB=90\nC=E\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double lnb = lnt * getParam(paramValues,0)/100;
      double lnc = (lnt - lnb)/3;
      double k = (lnt - lnb)/lnb;
      double dx = lnb * getParam(paramValues,1)/300;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnb, 0);
      baseTile.setPoint(2,  lnb, lnc);
      baseTile.setPoint(3,  lnb-dx, lnc-dx*k);
      baseTile.setPoint(4,  lnb-dx, (lnb-dx)*k);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[3].getX(4);
      offsets[3] = tiles[0].getY(3)-tiles[3].getY(4);
   }
}
