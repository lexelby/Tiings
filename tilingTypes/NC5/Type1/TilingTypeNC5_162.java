package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_162
   extends TilingType
{
   public TilingTypeNC5_162(){
      super( "NC5-162", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 20};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,4, 0},
            {0, 3,2, 1,4,0, 0},
            {1, 0,1, 2,0,4, 0},
      };
      info = "a=b\nd=2a\nA=90\nB+C=360\nC+D=180\n(D+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.4;
      double lnc = lnt * getParam(paramValues,0)/100;
      double lna = (lnt - lnc)/3;
      
      double dy = lnc / Math.sqrt(10);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, lna+dy*3, -dy);
      baseTile.setPoint(3, lna*3+dy*3, -dy);
      baseTile.setPoint(4, 0, lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[2].getX(4);
      offsets[1] = tiles[0].getY(3)-tiles[2].getY(4);
      offsets[2] = tiles[3].getX(3)-tiles[1].getX(2);
      offsets[3] = tiles[3].getY(3)-tiles[1].getY(2);
   }
}
