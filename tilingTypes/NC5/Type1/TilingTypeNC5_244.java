package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_244
   extends TilingType
{
   public TilingTypeNC5_244(){
      super( "NC5-244", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 75};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {1, 0,4, 0,4,0, 0},
            {1, 0,1, 2,1,0, 0},
            {2, 1,0, 0,3,4, 0},
            {2, 1,4, 4,4,1, 0},
      };
      info = "a=b\nc=e\nA=B\nB+C=180\nC+D=360\n(A+B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lna = .8;
      double lnb = lna * getParam(paramValues, 0)/100;
      
      double w = (lna-lnb)/2;
      double h = Math.sqrt(lna*lna - w*w);
      double w2 = w/2;
      double h2 = h/2;

      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, lna-w2, h2);
      baseTile.setPoint(3, w+w2, h2);
      baseTile.setPoint(4, w, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(3)-tiles[2].getX(4);
      offsets[1] = tiles[3].getY(3)-tiles[2].getY(4);
      offsets[2] = tiles[1].getX(0)-tiles[2].getX(3);
      offsets[3] = tiles[1].getY(0)-tiles[2].getY(3);
   }
}
